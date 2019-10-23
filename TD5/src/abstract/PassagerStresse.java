package tec;

    public class PassagerStresse extends PassagerAbstrait {
        public PassagerStresse (java.lang.String nom, int destination) {
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
      if (this.estAssis() && this.arretsRestants(arret) <= 3) {
        v.arretDemanderDebout(this);
      }
  }
}
