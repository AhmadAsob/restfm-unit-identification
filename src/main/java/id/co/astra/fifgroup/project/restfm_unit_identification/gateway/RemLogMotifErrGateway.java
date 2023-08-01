package id.co.astra.fifgroup.project.restfm_unit_identification.gateway;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemLogMotifErr;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.RemLogMotifErrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service("RemLogMotifErrGateway")
public class RemLogMotifErrGateway {

    @Autowired
    RemLogMotifErrRepository remLogMotifErrRepository;

    public RemLogMotifErr insertLogRemLogMotifErr(Object request, String response, String service, String detail){

        RemLogMotifErr remLogMotifErr = new RemLogMotifErr();
        UUID uuid = UUID.randomUUID();
        remLogMotifErr.setId(uuid.toString());
        System.out.println(remLogMotifErr.getId());
        remLogMotifErr.setRequest(convertObjectToJson(request, true));
        remLogMotifErr.setResponse(response);
        remLogMotifErr.setService(service);
        remLogMotifErr.setDetail(detail);
        remLogMotifErr.setCreatedDate(LocalDateTime.now());

        return remLogMotifErrRepository.save(remLogMotifErr);
    }

    private String convertObjectToJson(Object data, boolean isIncludeNull) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (isIncludeNull) {
            gsonBuilder.serializeNulls();
        }
        Gson gson = gsonBuilder.create();
        return gson.toJson(data);
    }
}
