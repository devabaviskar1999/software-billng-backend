package in.devabaviskar.billingsoftware.service;

import in.devabaviskar.billingsoftware.io.CategoryRequest;
import in.devabaviskar.billingsoftware.io.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse add(CategoryRequest request);

    List<CategoryResponse> read();
}
