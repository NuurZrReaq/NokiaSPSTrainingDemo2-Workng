package project.nokiaspstraining.demo.soap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import project.nokiaspstraining.demo.soap.repositories.UserRepositorySoap;
import project.nokiaspstraining.demo.wsdl.UserRequest;
import project.nokiaspstraining.demo.wsdl.UserResponse;


@Endpoint
public class UserControllerSoap {

    private static final String NAMESPACE_URI = "http://nokiaspstraining.project/demo/wsdl";

    @Autowired
    private UserRepositorySoap userRepositorySoap;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "userRequest")
    @ResponsePayload
    public UserResponse getUser(@RequestPayload UserRequest request) {
        UserResponse response = new UserResponse();
        response.setUser(userRepositorySoap.findUser(request.getName()));
        System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");

        return response;

    }



}
