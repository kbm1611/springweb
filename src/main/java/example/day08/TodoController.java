package example.day08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired private TodoRepository todoRepository;

    @PostMapping("/todo")
    public boolean todoAdd(@RequestBody TodoEntity todoEntity){
        todoRepository.save( todoEntity );
        return true;
    }

    @GetMapping("/todo")
    public List<TodoEntity> findAll(){
        return todoRepository.findAll();
    }
}
