package programmers.toss;

public class problem1 {
    public static void main(String[] args) {
        long orderAmount = 100;
        long taxFreeAmount = 0;
        long serviceFee = 0;

        System.out.println(calculate(orderAmount, taxFreeAmount, serviceFee));
    }

    public static long calculate(long orderAmount, long taxFreeAmount, long serviceFee) {
        if((double)orderAmount - (double)serviceFee - (double)taxFreeAmount == 1) return 0L;
        //이 방법으로 하면 테스트케이스 하나 오류남
        return (long) Math.ceil(((double)orderAmount - (double)serviceFee - (double)taxFreeAmount) / 10);
    }
}


// 부가가치세 = 과세 * 0.1(첫자리 올림)

//과세 금액 = 공급가액 - 비과세 금액

//공급대가 = 공급가액 + 부가가치세
// 봉사료 없으면 -> 공급대가 = 주문금액
// 봉사료 있으면 -> 주문금액 - 봉사료 = 공급대가

//공급대가액 - 비과세 = 1 ->부가가치세는 0원