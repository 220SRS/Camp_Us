package com.campus.campus.search.dto;

import com.campus.campus.search.entity.Store;
import com.campus.campus.search.utils.ScrollPaginationCollection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/*
* {
    "status": 200,
    "message": "OK",
    "data": {
        "contents": [
            {
                "createdAt": 1662647379,
                "updatedAt": 1662647379,
                "feedId": 20,
                "userId": 1,
                "title": "title",
                "content": "content",
                "imageUrls": [
                    "image.png"
                ]
            }
        ],
        "totalElements": 20,
        "nextCursor": 20
    }
}
* */
// 이 클래스가 data로 들어간다.
public class SearchDataResponse {
    private static final long LAST_CURSOR = -1L;

    // 클라이언트에게 최종적으로 전달될 데이터
    private List<Store> contents = new ArrayList<>();
    // 조회 가능한 데이터의 총 개수
    private long totalElements;
    // 다음 스크롤에서 사용할 커서의 값
    private long nextCursor;

    // 메서드
    private SearchDataResponse(List<Store> contents, long totalElements, long nextCursor) {
        this.contents = contents;
        this.totalElements = totalElements;
        this.nextCursor = nextCursor;
    }

    // 정적 팩토리 메서드 = 생성자~
    public static SearchDataResponse of(ScrollPaginationCollection<Store> storeScroll, long totalElements) {

        if (storeScroll.isLastScroll()) {
            // 호출 1
            return SearchDataResponse.newLastScroll(storeScroll.getCurrentScrollItems(), totalElements);
        }
        // 호출 2
        return SearchDataResponse.newScrollHasNext(storeScroll.getCurrentScrollItems(), totalElements, storeScroll.getNextCursor().getId());
    }

    // 1번 메서드 : 다음 스크롤이 존재하지 않을 경우 nextCursor에 -1L을 담아서 객체를 생성
    private static SearchDataResponse newLastScroll(List<Store> storeScroll, long totalElements) {
        return newScrollHasNext(storeScroll, totalElements, LAST_CURSOR);
    }

    // 2번 메서드 : 다음 스크롤이 존재하는 경우 nextCursor에 다음 커서 값을 담아서 객체를 생성
    private static SearchDataResponse newScrollHasNext(List<Store> storeScroll, long totalElements, long nextCursor) {
        // 호출 3
        return new SearchDataResponse(storeScroll, totalElements, nextCursor);
    }

//
//    // 3번 메서드 : contents로 전달할 데이터로 가공하기 위한 메서드
//    private static List<Store> getContents(List<Store> feedsScroll) {
//        return feedsScroll.stream()
//                .map(feed -> FeedsInfoResponse.of(feed, feedImages.getImagesByFeedId(feed.getId())))
//                .collect(Collectors.toList());
//    }

}
