package com.ksh;

import java.util.Arrays;

public class TestUrl {

    public static void main(String[] args) {
        String s = "https://api-it.cloud.capitalone.com/internal-operations/developer-platform/feature-management/environments/dev/features/{featureId}";
        String[] strings = s.split("/");
        System.out.println(strings[7]);
        Arrays.stream(strings).forEach(s1 -> System.out.println(s1));
    }
}
