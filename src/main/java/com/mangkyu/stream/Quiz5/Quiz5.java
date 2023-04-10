package com.mangkyu.stream.Quiz5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
    public int quiz1() {
        return Arrays.stream(this.STRING_ARR)
                .mapToInt((str) -> str.length())
                .sum();
    }

    // 5.2 문자열 중에서 가장 긴 것의 길이를 출력하시오.
    public int quiz2() {
        return Arrays.stream(this.STRING_ARR)
                .mapToInt((str) -> str.length())
                .max().getAsInt();
    }

    // 5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
    // 한국 로또뻔호는 1-45 로 된 숫자 6개로 된 집합
    public List<Integer> quiz3() {
        return Stream.generate(() -> (int) (Math.random() * 45) + 1)
                .distinct()
                .limit(6)
                .collect(Collectors.toList());
    }

    // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
    public List<Integer[]> quiz4() {
        return IntStream.rangeClosed(1, 6)
                .boxed()
                .flatMap((num) -> IntStream.range(1, 6).boxed().map((num2) -> new Integer[]{num, num2}))
                .filter((nums) -> nums[0] + nums[1] == 6)
                .collect(Collectors.toList());
    }

}
