package tec;

    public class PassagerStandard extends PassagerAbstrait {
        public PassagerStandard (java.lang.String nom, int destination) {
          super(nom, destination);
      }

      protected abstract void choixPlaceMontee(Vehicule v) {
      if (v.aPlaceAssise()) {
          (v.monteeDemanderAssis(this));
      } else if (v.aPlaceDebout()) {
        v.monteeDemanderDebout(this);
      }
    }
      protected abstract void choixPlaceArret(Vehicule v, int arret) {
      }
  }
}
