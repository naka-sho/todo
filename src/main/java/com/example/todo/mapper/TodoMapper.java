package com.example.todo.mapper;

import com.example.todo.model.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todo")
    List<Todo> findAll();

    @Select("SELECT * FROM todo WHERE id = #{id}")
    Todo findById(Long id);

    @Insert("INSERT INTO todo (title, description, completed) VALUES (#{title}, #{description}, #{completed})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Todo todo);

    @Update("UPDATE todo SET title = #{title}, description = #{description}, completed = #{completed} WHERE id = #{id}")
    void update(Todo todo);

    @Delete("DELETE FROM todo WHERE id = #{id}")
    void delete(Long id);
}
