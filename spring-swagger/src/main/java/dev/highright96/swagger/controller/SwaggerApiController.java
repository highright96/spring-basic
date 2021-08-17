package dev.highright96.swagger.controller;

import dev.highright96.swagger.dto.UserReq;
import dev.highright96.swagger.dto.UserRes;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 컨트롤러"})
@RestController
@RequestMapping("/api/swagger")
public class SwaggerApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(value = "x값", name = "x", required = true),
            @ApiImplicitParam(value = "y값", name = "y", required = true)
    })
    @GetMapping("/plus/{x}")
    public int plus(
            //@ApiParam(value = "x값", defaultValue = "20")
            @PathVariable int x,

            //@ApiParam(value = "y값", defaultValue = "20")
            @RequestParam int y) {
        return x + y;
    }

    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴하는 메소드")
    @GetMapping("/user")
    public UserRes user(UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost(@RequestBody UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }
}
