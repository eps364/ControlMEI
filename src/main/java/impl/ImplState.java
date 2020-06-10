package impl;

import entity.stage.State;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ImplState extends factory.Generic<State> {

    private static State state;

    public List<State> findAll() {
        EntityManager em = factory.Generic.Factory();
        List<State> estado;
        try {
            Query query = em.createNamedQuery("State.findAll");
            estado = query.getResultList();
        } catch (Exception e) {
            estado = new ArrayList();
        }

        return estado;
    }

    public static void updateState() {
        ImplState imp = new ImplState();
        state = new State();
        StringBuilder path = new StringBuilder();
        path.append("12, 'Acre', 'AC', 1 \n");
        path.append("27, 'Alagoas', 'AL', 2 \n");
        path.append("16, 'Amapá', 'AP', 1 \n");
        path.append("13, 'Amazonas', 'AM', 1 \n");
        path.append("29, 'Bahia', 'BA', 2 \n");
        path.append("23, 'Ceará', 'CE', 2 \n");
        path.append("53, 'Distrito Federal', 'DF', 5 \n");
        path.append("32, 'Espírito Santo', 'ES', 3 \n");
        path.append("52, 'Goiás', 'GO', 5 \n");
        path.append("21, 'Maranhão', 'MA', 2 \n");
        path.append("51, 'Mato Grosso', 'MT', 5 \n");
        path.append("50, 'Mato Grosso do Sul', 'MS', 5 \n");
        path.append("31, 'Minas Gerais', 'MG', 3 \n");
        path.append("15, 'Pará', 'PA', 1 \n");
        path.append("25, 'Paraíba', 'PB', 2 \n");
        path.append("41, 'Paraná', 'PR', 4 \n");
        path.append("26, 'Pernambuco', 'PE', 2 \n");
        path.append("22, 'Piauí', 'PI', 2 \n");
        path.append("33, 'Rio de Janeiro', 'RJ', 3 \n");
        path.append("24, 'Rio Grande do Norte', 'RN', 2 \n");
        path.append("43, 'Rio Grande do Sul', 'RS', 4 \n");
        path.append("11, 'Rondônia', 'RO', 1 \n");
        path.append("14, 'Roraima', 'RR', 1 \n");
        path.append("42, 'Santa Catarina', 'SC', 4 \n");
        path.append("35, 'São Paulo', 'SP', 3 \n");
        path.append("28, 'Sergipe', 'SE', 2 \n");
        path.append("17, 'Tocantins', 'TO', 1 ");

        String[] split = path.toString().split("\n");

        for (String v : split) {
            String[] set = v.split(",");
            
            state.setStateCode(null);
            state.setStateName(set[1].trim().replace("'", ""));
            state.setStateInitials(set[2].trim().replace("'", ""));
            state.setRegionCode(Integer.parseInt(set[3].trim()));
            imp.save(state);
        }

        if (imp.findAll().size() <= 27) {
            updateState(); // 
        }

    }

}
