package example.day02.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day02/practice2")
public class PostController {

    @PostMapping("/post")
    public boolean method1(){
        return false;
    }

    @GetMapping("/post")
    public List<Map<String,String>> method2(){
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("bno", "1");
        map1.put("btitle", "제목");
        list.add(map1);
        Map<String, String> map2 = new HashMap<>();
        map2.put("bno", "2");
        map2.put("btitle", "제목2");
        list.add(map2);
        return list;
    }

    @GetMapping("/post/view")
    public Map<String, Object> method3(){
        Map<String, Object> map = new HashMap<>();
        map.put("bno", "1");
        map.put("btitle", "제목");
        return map;
    }

    @PutMapping("/post")
    public boolean method4(){
        return true;
    }

    @DeleteMapping("/post")
    public int method5(){
        return 3;
    }
}
