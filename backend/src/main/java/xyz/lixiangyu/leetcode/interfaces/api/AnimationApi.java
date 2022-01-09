package xyz.lixiangyu.leetcode.interfaces.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.lixiangyu.leetcode.infrastructure.model.animation.Animation;
import xyz.lixiangyu.leetcode.infrastructure.model.animation.frame.Frame;
import xyz.lixiangyu.leetcode.infrastructure.model.animation.shape.Rect;
import xyz.lixiangyu.leetcode.infrastructure.model.common.RestResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lixiangyu
 */
@RestController
public class AnimationApi {
    @GetMapping("/animation")
    public RestResponse<List<Animation>> getAnimationInfoByName(@RequestParam("name") String name) throws Exception {
        Animation animation = new Animation();
        Rect rect = new Rect();
        rect.setWidth(40);
        rect.setHeight(40);
        rect.setX(10);
        rect.setY(150);
        rect.setStyle("fill: red; stroke: black;");

        Frame frame = new Frame();
        frame.setAnimationType("to");
        List<String> vars = new ArrayList<>();
        vars.add("{\"x\":69, \"fill\": \"green\"}");
        frame.setVars(vars);
        frame.setTime(0);

        animation.setShape(rect);
        animation.setFrames(Collections.singletonList(frame));


        return RestResponse.success(Collections.singletonList(animation));
    }

    public static void main(String[] args) throws Exception {
        Animation animation = new Animation();
        Rect rect = new Rect();
        rect.setWidth(40);
        rect.setHeight(40);
        rect.setX(10);
        rect.setY(150);
        rect.setStyle("fill: red; stroke: black;");

        Frame frame = new Frame();
        frame.setAnimationType("to");
        List<String> vars = new ArrayList<>();
        vars.add("{\"x\":69, \"fill\": \"green\"}");
        frame.setVars(vars);
        frame.setTime(0);

        animation.setShape(rect);
        animation.setFrames(Collections.singletonList(frame));

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(animation));
    }
}
