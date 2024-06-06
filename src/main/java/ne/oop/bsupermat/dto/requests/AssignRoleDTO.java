package ne.oop.bsupermat.dto.requests;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class AssignRoleDTO {
    private UUID roleId;
    private Set<UUID>users;
}
