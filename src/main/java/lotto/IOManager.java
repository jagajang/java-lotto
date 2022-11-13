package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoConfig;
import lotto.message.IOMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOManager {
    private static void printEmptyLine() {
        System.out.println(IOMessage.EMPTY_LINE.getMessage());
    }
    public static int scanMoney() throws IllegalArgumentException {
        System.out.println(IOMessage.ASK_PRICE.getMessage());

        try {
            int price = Integer.parseInt(Console.readLine());
            printEmptyLine();

            return price;
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> scanAnswer() {
        return Arrays.stream(Console.readLine().split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public static void printLottoBought(int num) {
        System.out.println(String.valueOf(num) + IOMessage.LOTTO_BUY_NUM.getMessage());
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println(String.valueOf(lottoList.size()) + IOMessage.LOTTO_BUY_NUM.getMessage());
        for(Lotto lotto : lottoList) {
            printLotto(lotto);
        }
        printEmptyLine();
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
