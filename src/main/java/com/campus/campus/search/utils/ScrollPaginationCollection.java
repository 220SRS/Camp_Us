package com.campus.campus.search.utils;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;

//참고블로그 : https://velog.io/@orijoon98/Spring-%EB%AC%B4%ED%95%9C%EC%8A%A4%ED%81%AC%EB%A1%A4-%EA%B5%AC%ED%98%84-1-%EC%BB%A4%EC%84%9C-%EA%B8%B0%EB%B0%98-%ED%8E%98%EC%9D%B4%EC%A7%80%EB%84%A4%EC%9D%B4%EC%85%98
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
// 롬복 : 클래스 내부에 정의된 final 필드에 대해 생성자를 자동으로 생성해주는 역할을 한다.
public class ScrollPaginationCollection<T> {
    private final List<T> itemsWithNextCursor; // 현재 스크롤의 요소 + 다음 스크롤의 요소 1개 (다음 스크롤이 있는지 확인을 위한)
    private final int countPerScroll; // 한번의 스크롤에 표시될 아이템의 수

    /* 정적 팩토리 메서드 of */
    public static <T> ScrollPaginationCollection<T> of(List<T> itemsWithNextCursor, int size) {
        // 생성자 호출
        return new ScrollPaginationCollection<>(itemsWithNextCursor, size);
    }

    /* 마지막 스크롤인지 확인 */
    public boolean isLastScroll() {
        // 정확한 원리는 모르겠고...
        return this.itemsWithNextCursor.size() <= countPerScroll;
    }

    /* 마지막 스크롤일 경우 itemsWithNextCursor 전체를 반환하고,
    * 아닐 경우 다음 스크롤의 데이터 1개를 제외하고 return 한다. */
    public List<T> getCurrentScrollItems() {
        if (isLastScroll()) {
            return this.itemsWithNextCursor;
        }
        return this.itemsWithNextCursor.subList(0, countPerScroll);
        //그런데 이거 항상 0부터 시작하는 거 아닌가?
        //하나 스크롤 땡기고 나면 리스트의 앞부분이 잘려나가나?
    }

    /* 현재 스크롤의 데이터 중 마지막 데이터를 cursor로 사용하고 이를 return 한다. */
    public T getNextCursor() {
        return itemsWithNextCursor.get(countPerScroll - 1);
    }
}
