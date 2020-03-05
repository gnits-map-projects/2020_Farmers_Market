package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPARegisterRepository.class)
public interface RegisterRepository {

    CompletionStage<Register> add(Register register);

    CompletionStage<Register> getFarmer(Long fid);

    abstract Register login(String email,String password);

    public CompletionStage<Register> update(Long id, String name, String email, String password, String mobile);
}
