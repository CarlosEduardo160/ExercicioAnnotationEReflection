import java.lang.reflect.InvocationTargetException;

public class Main {
    static void main() throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        Validador validador = new Validador();

        Usuario pessoa1 = new Usuario();
        pessoa1.setNome("Pessoa 1");
        pessoa1.setEmail("exemplo@gmail.com");
        pessoa1.setSenha("123456789");

        Usuario pessoa2 = new Usuario();
        //pessoa2.setNome("Pessoa 2");
        pessoa2.setEmail("exemplo@gmail.com");
        pessoa2.setSenha("12345");

        Usuario[] usuarios = new Usuario[2];
        usuarios[0] = pessoa1;
        usuarios[1] = pessoa2;

        for (int i = 0; i < usuarios.length; i++) {
            System.out.println("Validando o usuário: " + (i + 1));
            validador.validarUsuario(usuarios[i]);
        }
    }
}
