package in.devabaviskar.billingsoftware.controller;


import in.devabaviskar.billingsoftware.io.CategoryRequest;
import in.devabaviskar.billingsoftware.io.CategoryResponse;
import in.devabaviskar.billingsoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse add(@RequestBody CategoryRequest request){
           return categoryService.add(request);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> read(){
        return categoryService.read();
    }
}
