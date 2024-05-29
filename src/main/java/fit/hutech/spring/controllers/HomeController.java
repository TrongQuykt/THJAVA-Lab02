package fit.hutech.spring.controllers;
import fit.hutech.spring.models.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home() {
        return "home/index";
    }
    @GetMapping("/contact")
    public String contact() {
        return "home/contact";
    }
    @GetMapping("/subjects")
    public String subjects(Model model) {
        model.addAttribute("subjects", getSubjects());
        return "home/subjects";
    }

    @PostMapping("/result")
    public String submitContact(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String message,
                                Model model) {
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("message", message);
        model.addAttribute("date", currentDate);
        return "home/result";
    }

    private List<Subject> getSubjects() {
        return List.of(
                new Subject("COS101", "Mạng máy tính", "MMT.jpg"),
                new Subject("C0S102", "Cấu trúc dữ liệu và giải thuật", "CTDL&GT.jpg"),
                new Subject("C0S103", "Trí tuệ nhân tạo", "AI.jpg"),
                new Subject("C0S104", "Công nghệ phần mềm", "CNPM.jpg"),
                new Subject("C0S105", "Cơ sở dữ liệu", "CSDL.jpg")
        );
    }
}
