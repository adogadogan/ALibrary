package com.example.library;

import com.example.library.model.Book;
import com.example.library.model.Publisher;
import com.example.library.repository.BookRepository;
import com.example.library.repository.PublisherRepository;
import com.example.library.service.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.InstanceOfAssertFactories.optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@Import({CacheConfig.class, BookServiceImpl.class,PublisherServiceImpl.class})
@EnableCaching
@ExtendWith(SpringExtension.class)
@ImportAutoConfiguration(classes = { CacheAutoConfiguration.class})
public class CachingTests {

    @MockBean
    private BookRepository mockBookRepository;
    @MockBean
    private PublisherRepository mockPublisherRepository;

    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private CacheManager cacheManager;

    private Publisher publisher;


    @Test
    void cacheTest1(){
        Publisher aPublisher = new Publisher(13L,"A yayinevi");
        Publisher bPublisher = new Publisher(14L,"B yayinevi");
        given(mockPublisherRepository.findById(13L))
                .willReturn(Optional.of(aPublisher));
        given(mockPublisherRepository.findById(14L))
                .willReturn(Optional.of(bPublisher));

        long instant = Instant.now().toEpochMilli();
        Publisher publisherCacheMiss = publisherService.findById(13L);
        long afterMiss = Instant.now().toEpochMilli();
        Publisher publisherCacheHit = publisherService.findById(13L);
        long afterHit = Instant.now().toEpochMilli();
        Publisher publisherCacheHit2 = publisherService.findById(13L);
        long afterHit2 = Instant.now().toEpochMilli();

        assertThat(publisherCacheMiss).isEqualTo(aPublisher);
        assertThat(publisherCacheHit).isEqualTo(aPublisher);
        assertThat(publisherCacheHit2).isEqualTo(aPublisher);

        verify(mockPublisherRepository,times(1)).findById(13L);

    }

    @Test
    void cacheTest2(){
        Book aBook = new Book(1L,123,"a book title",3,"a genre");
        Book bBook = new Book(2L,456,"b book title",2,"b genre");

        given(mockBookRepository.findById(1L))
                .willReturn(Optional.of(aBook));
        given(mockBookRepository.findById(2L))
                .willReturn(Optional.of(bBook));

        Book aBookMiss = bookService.findById(1L);
        Book aBookHit = bookService.findById(1L);

        Book bBookMiss = bookService.findById(2L);
        Book bBookMissAgain = bookService.findById(2L);

        assertThat(aBookMiss).isEqualTo(aBook);
        assertThat(aBookHit).isEqualTo(aBook);
        assertThat(bBookMiss).isEqualTo(bBook);
        assertThat(bBookMissAgain).isEqualTo(bBook);

        verify(mockBookRepository,times(1)).findById(1L);
        verify(mockBookRepository,times(2)).findById(2L);

    }

//    @TestConfiguration
//    static class EmbeddedRedisConfiguration {
//
//        private final RedisServer redisServer;
//
//        public EmbeddedRedisConfiguration() throws IOException {
//            this.redisServer = new RedisServer();
//        }
//
//        @PostConstruct
//        public void startRedis() {
//            redisServer.start();
//        }
//
//        @PreDestroy
//        public void stopRedis() {
//            this.redisServer.stop();
//        }
//    }
//
//    private Object itemFromCache() {
//        return cacheManager.getCache("itemCache").get(13L).get();
//    }


}
