package blog_management.service.impl;

import blog_management.model.Blog;
import blog_management.repository.IBlogRepository;
import blog_management.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> findByName(String keySearch, Pageable pageable) {
        return iBlogRepository.findByName(keySearch, pageable);
    }

    @Override
    public Page<Blog> findByCategory(int chooseSelect, Pageable pageable) {
        return iBlogRepository.findByCategory(chooseSelect, pageable);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }
}
