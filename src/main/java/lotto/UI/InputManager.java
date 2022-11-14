package lotto.UI;

import lotto.UI.message.ErrorCode;
import lotto.UI.message.UIMessage;
import lotto.config.LottoConfig;

import java.util.List;
import java.util.stream.Collectors;

public class InputManager {
    public static int scanMoney() throws IllegalArgumentException {
        try {
            System.out.println(UIMessage.ASK_PRICE.getMessage());
            int price = UIScanner.scanInt();
            OutputManager.printEmptyLine();

            assert(price > 0);
            assert(price % LottoConfig.LOTTO_PRICE == 0);

            return price;
        } catch(Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_PURCHASE_PRICE.getValue());
        }
    }

    public static List<Integer> scanAnswer() throws IllegalArgumentException {
        try {
            System.out.println(UIMessage.ASK_ANSWER.getMessage());

            return UIScanner.scanIntStream().collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_ANSWER.getValue());
        } finally {
            OutputManager.printEmptyLine();
        }
    }

    public static int scanBonus() throws IllegalArgumentException {
        try {
            System.out.println(UIMessage.ASK_BONUS.getMessage());

            return UIScanner.scanInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_ANSWER.getValue());
        } finally {
            OutputManager.printEmptyLine();
        }
    }
}
