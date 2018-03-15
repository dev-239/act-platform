package no.mnemonic.act.platform.rest.mappings;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import no.mnemonic.act.platform.rest.api.ResultStash;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MismatchedInputMapper implements ExceptionMapper<MismatchedInputException> {

  @Override
  public Response toResponse(MismatchedInputException ex) {
    return ResultStash.builder()
            .setStatus(Response.Status.PRECONDITION_FAILED)
            .addFieldError("JSON field has an invalid type.", "invalid.json.field.type", MapperUtils.printPropertyPath(ex), "")
            .buildResponse();
  }

}
