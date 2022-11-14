package lotto.IO;

import camp.nextstep.edu.missionutils.Console;
import lotto.IO.message.ErrorCode;
import lotto.IO.message.IOMessage;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputManager {
    public static int scanMoney() throws IllegalArgumentException {
        try {
            System.out.println(IOMessage.ASK_PRICE.getMessage());
            int price = Integer.parseInt(Console.readLine());
            OutputManager.printEmptyLine();

            return price;
        } catch(Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_PURCHASE_TYPE.getErrorMessage());
        }
    }

    public static List<Integer> scanAnswer() throws IllegalArgumentException {
        try {
            System.out.println(IOMessage.ASK_ANSWER.getMessage());

            return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_ANSWER.getErrorMessage());
        } finally {
            OutputManager.printEmptyLine();
        }
    }

    public static int scanBonus() throws IllegalArgumentException {
        try {
            System.out.println(IOMessage.ASK_BONUS.getMessage());

            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_ANSWER.getErrorMessage());
        } finally {
            OutputManager.printEmptyLine();
        }
    }
}
