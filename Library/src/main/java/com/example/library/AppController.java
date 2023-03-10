package com.example.library;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller; // Позволяет указать адрес страницы
import org.springframework.ui.Model; // Интерфейс, который необходим для взаимодействия Controller и конфигуратора modelviewcontroller, а также для добавления всех элементов web интерфейса
import org.springframework.web.bind.annotation.ModelAttribute; // Аннотация для связывания параметра и метода, который будет выводиться в web интерфейсе
import org.springframework.web.bind.annotation.PathVariable; // Аннотация необходимая для получения параметра из адресной строки браузера
import org.springframework.web.bind.annotation.RequestMapping; // Аннотация для создания адреса браузерной строки(URL) для создания адреса контроллера
import org.springframework.web.bind.annotation.RequestMethod; // Метод указывающий с помощью какого http запроса будем передавать данные (POST,GET)
import org.springframework.web.servlet.ModelAndView; // Метод позволяющий указать название html страниц, которые мы подвязываем к нашему модулю

@Controller
public class AppController {

    @Autowired
    private LibraryService service;

    @RequestMapping("/") // "/" - означает, что будет открываться главная страница
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Library> listLibraries = service.listAll(keyword);
        model.addAttribute("listLibraries", listLibraries);
        model.addAttribute("keyword", keyword);
        return "index"; // Возвращение html страницы
    }

    @RequestMapping("/new") // Контроллер по добавлению книги
    public String showNewLibraryForm(Model model){
        Library library = new Library();
        model.addAttribute("library", library); // первый параметр название database
        return "new_library"; // Возвращение html страницы
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLibrary(@ModelAttribute("library") Library library){
        service.save(library);
        return "redirect:/"; // Сохранение и перенос на главную страницу
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditLibraryForm(@PathVariable(name = "id") Long id) { // id - параметр из браузерной строки
        ModelAndView mav = new ModelAndView("edit_library");
        Library library = service.get(id);
        mav.addObject("library", library);
        return mav; // Возвращаем страницу с данными о книге по id
    }

    @RequestMapping("/delete/{id}")
    public String deleteLibrary(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/"; // Сохранение и перенос на главную страницу
    }
    @RequestMapping("/histogram")
    public String showNewHistogramForm(Model model, @Param("keyword") String keyword){
        List<Library> listLibraries = service.listAll(keyword);
        model.addAttribute("listLibraries", listLibraries);
        model.addAttribute("keyword", keyword);
        return "histogram"; // Возвращение html страницы
    }


}
