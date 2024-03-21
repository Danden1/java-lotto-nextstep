package lotto;

import lotto.domain.*;
import lotto.utils.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {

    private final LottoSeller mockLottoSeller = new LottoSeller(new TestNumberGenerator(List.of(1, 2, 3, 4, 5, 6)));

    @ParameterizedTest
    @DisplayName("로또 구매 테스트")
    @CsvSource(value = {"14000,14", "4000,4", "1000,1"}, delimiter = ',')
    void testPurchaseLotto(int price, int expected) {
        User user = new User(mockLottoSeller);
        user.purchaseLottos(price);
        assertThat(user.getLottos()).hasSize(expected);
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 가격으로 로또 살 때 테스트")
    @ValueSource(ints = {100, 1200, 12300})
    void testInvalidPurchase(int price) {
        User user = new User(mockLottoSeller);
        assertThatIllegalArgumentException().isThrownBy(() -> user.purchaseLottos(price));
    }

    @ParameterizedTest
    @DisplayName("로또 수익률 및 결과 테스트")
    @MethodSource("getLottosAndRateOfReturn")
    void testRateOfReturn(Lotto winningLotto, int price, double expectedRateOfReturn, Map<LottoWinningRank, Integer> expectedLottoResultCount) {
        User user = new User(mockLottoSeller);
        user.purchaseLottos(price);
        UserLottoResult userLottoResult = user.getUserLottoResult(winningLotto);

        assertThat(userLottoResult.getRateOfReturn()).isEqualTo(expectedRateOfReturn);

        for (Map.Entry<LottoWinningRank, Integer> lottoResultCount : expectedLottoResultCount.entrySet()) {
            assertThat(userLottoResult.getCountLottoResult(lottoResultCount.getKey())).isEqualTo(lottoResultCount.getValue());
        }

    }

    private static Stream<Arguments> getLottosAndRateOfReturn() {
        return Stream.of(
                Arguments.of(new Lotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6))), 4000, 2000000.0, getLottoResultMap(4, 0, 0, 0)),
                Arguments.of(new Lotto(new LottoNumbers(List.of(2, 3, 4, 5, 6, 7))), 5000, 1500, getLottoResultMap(0, 5, 0, 0)),
                Arguments.of(new Lotto(new LottoNumbers(List.of(3, 4, 5, 6, 7, 8))), 6000, 50.0, getLottoResultMap(0, 0, 6, 0)),
                Arguments.of(new Lotto(new LottoNumbers(List.of(4, 5, 6, 7, 8, 9))), 3000, 5.0, getLottoResultMap(0, 0, 0, 3)),
                Arguments.of(new Lotto(new LottoNumbers(List.of(5, 6, 7, 8, 9, 10))), 4000, 0.0, getLottoResultMap(0, 0, 0, 0))

        );
    }

    private static Map<LottoWinningRank, Integer> getLottoResultMap(int first, int second, int third, int fourth) {
        Map<LottoWinningRank, Integer> map = new EnumMap<>(LottoWinningRank.class);
        map.put(LottoWinningRank.FIRST, first);
        map.put(LottoWinningRank.SECOND, second);
        map.put(LottoWinningRank.THIRD, third);
        map.put(LottoWinningRank.FOURTH, fourth);

        return map;
    }
}
