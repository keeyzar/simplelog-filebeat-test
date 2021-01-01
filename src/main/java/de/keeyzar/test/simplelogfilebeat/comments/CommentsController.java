package de.keeyzar.test.simplelogfilebeat.comments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }


    @GetMapping(value = "/comments")
    public List<String> getComments(){
        log.info("Comments were requested, delegating to service");
        List<String> comments = commentsService.getComments();
        log.info("Comments were collected and are ready to be returned");
        return comments;
    }
}
