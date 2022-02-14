package com.ttasjwi.LadderGame.view.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class InputViewImpl implements InputView {

    private static final String ENTRY_PROMPT = "entry > ";
    private static final String HEIGHT_PROMPT = "height > ";

    private final Scanner scanner;
    private final Validator validator;
    
    @Override
    public int inputEntry() {
        System.out.println("참여할 사람은 몇 명인가요?");
        System.out.print(ENTRY_PROMPT);
        try {
            String strEntry = scanner.nextLine();
            int intEntry = Integer.parseInt(strEntry);
            validator.entryValidation(intEntry);
            return intEntry;
        } catch (NumberFormatException nfe) {
            System.out.println("사람 수는 숫자여야합니다.");
        } catch (IllegalArgumentException ile) {
            System.out.println(ile.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputEntry();
    }
    
    @Override
    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        System.out.print(HEIGHT_PROMPT);
        try {
            String strMaxHeight = scanner.nextLine();
            int intHeight = Integer.parseInt(strMaxHeight);
            validator.heightValidate(intHeight);
            return intHeight;
        } catch (NumberFormatException nfe) {
            System.out.println("사다리 높이는 숫자여야합니다.");
        } catch (IllegalArgumentException ile) {
            System.out.println(ile.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputHeight();
    }

}
