package org.jiho.medium;

/*
마나커 알고리즘 참고 글:
https://school.programmers.co.kr/questions/73747?referer=collection-of-questions
 */
public class Problem5 {
    public String longestPalindrome(String s) {
        String hashInsertedS = insertHashBetweenCharacters(s);
        int strLen = hashInsertedS.length();
        int[] LP = new int[strLen];
        int curLPCenter = 0;
        int curLPRight = 0;

        for (int i = 0; i < strLen; i++) {
            // 현재 가징 긴 펠린드롬 내부에 속하는 경우
            if (i < curLPRight) {
                int symmetryPos = curLPCenter - (i - curLPCenter);
                int searchRightPos = Math.min(i + LP[symmetryPos], curLPRight) + 1;
                int searchLeftPos = i - (searchRightPos - i);

                while (searchRightPos < strLen && searchLeftPos >= 0) {
                    if (hashInsertedS.charAt(searchLeftPos) == hashInsertedS.charAt(searchRightPos)) {
                        searchRightPos++;
                        searchLeftPos--;
                    } else {
                        break;
                    }
                }
                LP[i] = searchRightPos - 1 - i;
            } else {
                int searchRightPos = i + 1;
                int searchLeftPos = i - (searchRightPos - i);

                while (searchRightPos < strLen && searchLeftPos >= 0) {
                    if (hashInsertedS.charAt(searchLeftPos) == hashInsertedS.charAt(searchRightPos)) {
                        searchRightPos++;
                        searchLeftPos--;
                    } else {
                        break;
                    }
                }
                LP[i] = searchRightPos - 1 - i;
            }

            int curPRight = i + LP[i];
            if (curPRight > curLPRight) {
                curLPRight = curPRight;
                curLPCenter = i;
            }
        }

        int[] maxAndIndex = findMaxAndIndex(LP, hashInsertedS);
        int maxLPLength = maxAndIndex[0];
        int maxLPPos = maxAndIndex[1];
        String result = hashInsertedS.substring(maxLPPos - maxLPLength, maxLPPos + maxLPLength + 1);
        return result.replace("#", "");
    }

    private static String insertHashBetweenCharacters(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("스트링은 null 이거나 비어있을 수 없습니다.");
        }

        StringBuilder sb = new StringBuilder();

        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            sb.append('#').append(s.charAt(i));
        }

        return sb.toString();
    }


    private static int[] findMaxAndIndex(int[] array, String s) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("배열은 null 이거나 비어있을 수 없습니다.");
        }

        int max = array[0];
        int index = 0;

        for (int i = 1; i < array.length; i++) {
            int refinedVal;
            if(s.charAt(i) == '#') {
                refinedVal = (array[i] / 2 + array[i] % 2) * 2;
            } else {
                refinedVal = (array[i] / 2) * 2 + 1;
            }
            if (refinedVal > max) {
                max = refinedVal;
                index = i;
            }
        }

        return new int[]{array[index], index};
    }
}
