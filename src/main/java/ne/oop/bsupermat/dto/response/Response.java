package ne.oop.bsupermat.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ne.oop.bsupermat.enums.ResponseType;

@Getter
@Setter
@RequiredArgsConstructor
public class Response<T> {
    private ResponseType responseType;
    private T payload;
}
