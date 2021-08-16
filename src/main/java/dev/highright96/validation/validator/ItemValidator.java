package dev.highright96.validation.validator;

import dev.highright96.validation.dto.Item;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Item item = (Item) target;

        if (item.getName() == null) {
            errors.rejectValue("name", null, "이름을 입력해주세요.");
        }

        if (item.getPrice() == null || item.getPrice() < 1000) {
            errors.rejectValue("price", null, "가격은 1000원보다 커야 합니다.");
        }

        if (item.getQuantity() == null || item.getQuantity() > 10000) {
            errors.rejectValue("quantity", null, "수량은 10000개보다 적여야 합니다.");
        }
    }
}
