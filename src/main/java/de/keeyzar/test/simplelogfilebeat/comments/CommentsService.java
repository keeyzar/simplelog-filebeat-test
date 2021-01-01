package de.keeyzar.test.simplelogfilebeat.comments;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentsService {

    public List<String> getComments() {
        log.info("Service was called for comments; constructing comments");
        log.info("Comments were constructed, returning to caller");
        return List.of("comment1", "comment2");
    }
}
