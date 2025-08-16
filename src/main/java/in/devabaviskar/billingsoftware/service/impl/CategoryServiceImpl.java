package in.devabaviskar.billingsoftware.service.impl;

import in.devabaviskar.billingsoftware.entity.CategoryEntity;
import in.devabaviskar.billingsoftware.io.CategoryRequest;
import in.devabaviskar.billingsoftware.io.CategoryResponse;
import in.devabaviskar.billingsoftware.repository.CategoryRepository;
import in.devabaviskar.billingsoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse add(CategoryRequest request) {
        CategoryEntity newCategory = convertToEntity(request);
        categoryRepository.save(newCategory);
        return convertToResponse(newCategory);//in here we can use any mapper library but for now keep it simple
    }

    @Override
    public List<CategoryResponse> read() {
       List<CategoryEntity> categories = categoryRepository.findAll();
       List<CategoryResponse> categoryResponses = categories.stream().map((category) -> CategoryResponse.builder().name(category.getName())
               .description(category.getDescription()).bgColor(category.getBgColor()).createdAt(category.getCreatedAt())
               .updatedAt(category.getUpdatedAt()).imgUrl(category.getImgUrl()).build()
       ).toList();
       return categoryResponses;
    }

    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
        return CategoryResponse.builder().categoryId(newCategory.getCategoryId())
                .name(newCategory.getName()).description(newCategory.getDescription())
                .bgColor(newCategory.getBgColor()).imgUrl(newCategory.getImgUrl())
                .createdAt(newCategory.getCreatedAt()).updatedAt(newCategory.getUpdatedAt()).build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
        return CategoryEntity.builder().categoryId(UUID.randomUUID().toString()) //unique id will generate
                .name(request.getName()).description(request.getDescription()).bgColor(request.getBgColor()).build();
    }


}
