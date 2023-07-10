package com.lordrahl.newechoservice.services;

import com.lordrahl.bookservice.BookFindRequest;
import com.lordrahl.bookservice.BookResponse;
import com.lordrahl.bookservice.BookServiceGrpc;
import com.lordrahl.bookservice.BookServiceProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
public class AuthorService extends BookServiceGrpc.BookServiceImplBase {
    @Override
    public void allBooks(BookFindRequest request, StreamObserver<BookResponse> responseObserver) {
        for (int i = 0; i < 100; i++) {
            responseObserver.onNext(BookResponse.newBuilder()
                    .setTitle("Things fall apart volume " + i)
                    .setIsbn(UUID.randomUUID().toString())
                    .setEdition(String.valueOf(i))
                    .build());
        }
        responseObserver.onCompleted();
    }
}
