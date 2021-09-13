package com.learning.server.metadata;

import io.grpc.*;

import java.util.Objects;

public class AuthInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
//        String clientToken = metadata.get(ServerConstants.TOKEN);
        String clientToken = metadata.get(ServerConstants.USER_TOKEN);
        if (this.validate(clientToken)) {
            UserRole userRole = extract(clientToken);
            Context context = Context.current().withValue(ServerConstants.CTX_USER_ROLE, userRole);
            return Contexts.interceptCall(context, serverCall, metadata, serverCallHandler);
//            return serverCallHandler.startCall(serverCall, metadata);
        } else {
            Status status = Status.UNAUTHENTICATED.withDescription("invalid token/expired token");
            serverCall.close(status, metadata);
        }
        return new ServerCall.Listener<ReqT>() {
        };
    }

    private boolean validate(String token) {
//        return Objects.nonNull(token) && token.equals("bank-client-secret");
//        return Objects.nonNull(token) && token.equals("user-secret-3");
        return Objects.nonNull(token) && (token.startsWith("user-secret-3") || token.startsWith("user-secret-2"));
    }

    private UserRole extract(String jwt) {
        return jwt.endsWith("prime") ? UserRole.PRIME : UserRole.STANDARD;
    }
}
