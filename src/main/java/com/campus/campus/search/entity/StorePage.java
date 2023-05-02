package com.campus.campus.search.entity;

import lombok.Getter;

import java.util.List;

public class StorePage<Store> {
    private final List<Store> content; // 페이지에 포함되는 데이터 목록
    private final int pageNumber; // 현재 페이지 번호
    private final int pageSize; // 페이지당 표시할 항목 수
    private final long totalElements; // 전체 데이터 항목 수

    /* 필요한 값

    전체 항목 수: 모든 페이지를 합친 전체 항목 수
    전체 페이지 수: 전체 항목 수를 페이지당 표시할 항목 수로 나눈 값을 올림한 값

     */

    // of랑 <T> 뭔가 안됨/.... > 찾아봐야함..
//    public StorePage<Store> of(List<Store> content, int pageNumber, int pageSize, long totalElements){
//        return new StorePage<>(content, pageNumber, pageSize, totalElements);
//    }
    public StorePage(List<Store> content, int pageNumber, int pageSize, long totalElements) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
    }

    public List<Store> getContent() {
        return content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public boolean hasNextPage() {
        return (pageNumber + 1) * pageSize < totalElements;
    }

}
