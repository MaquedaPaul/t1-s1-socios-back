package ar.utn.aceleradora.gestion.socios.modelos.empresa;

public enum TipoSocio {
  SOCIO_ADHERENTE {
    @Override
    public String getDescripcion() {
      return "Empresa";
    }
  },
  SOCIO_PLENARIO {
    @Override
    public String getDescripcion() {
      return "Cámara";
    }
  };

  public abstract String getDescripcion();
}
