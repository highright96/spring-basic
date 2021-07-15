package dev.highright96.upload.controller;

import dev.highright96.upload.domain.Item;
import dev.highright96.upload.domain.UploadFile;
import dev.highright96.upload.dto.ItemForm;
import dev.highright96.upload.repository.ItemRepository;
import dev.highright96.upload.service.FileStoreService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final FileStoreService fileStoreService;

    @GetMapping("/items/new")
    public String newItem(@ModelAttribute ItemForm form) {
        return "upload/item-form";
    }

    @PostMapping("/items/new")
    public String saveItem(@ModelAttribute ItemForm form, RedirectAttributes redirectAttributes)
        throws IOException {
        UploadFile attachFile = fileStoreService.storeFile(form.getAttachFile());
        List<UploadFile> storeImageFiles = fileStoreService.storeFiles(form.getImageFiles());

        //데이터베이스에 저장 (데이터베이스에는 저장 경로만, 파일은 s3 또는 서버에)
        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setAttachFile(attachFile);
        item.setImageFiles(storeImageFiles);
        itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", item.getId());

        return "redirect:/items/{itemId}";
    }

    @GetMapping("/items/{id}")
    public String items(@PathVariable Long id, Model model) {
        Item item = itemRepository.findById(id);
        model.addAttribute("item", item);
        return "upload/item-view";
    }
}
