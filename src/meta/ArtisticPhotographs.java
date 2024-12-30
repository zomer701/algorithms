package meta;

import java.util.ArrayList;
import java.util.List;

public class ArtisticPhotographs {

    public static void main(String[] args) {
        System.out.println(countArtisticPhotos(5, 1, 2, "APABA"));
    }

    public static int countArtisticPhotos(int N, int X, int Y, String C) {
        List<Integer> photographers = new ArrayList<>();
        List<Integer> actors = new ArrayList<>();
        List<Integer> backdrops = new ArrayList<>();

        // First pass: collect all positions of 'P', 'A', and 'B'
        for (int i = 0; i < N; i++) {
            if (C.charAt(i) == 'P') {
                photographers.add(i);
            } else if (C.charAt(i) == 'A') {
                actors.add(i);
            } else if (C.charAt(i) == 'B') {
                backdrops.add(i);
            }
        }

        int result = 0;

        // For each actor, find valid photographers and backdrops
        for (int actor : actors) {
            // Check photographers to the left and right of the actor
            for (int photographer : photographers) {
                int photographerToActorDistance = Math.abs(actor - photographer);

                // Ensure the photographer is within the valid distance
                if (photographerToActorDistance >= X && photographerToActorDistance <= Y) {
                    // Check backdrops to the left and right of the actor
                    for (int backdrop : backdrops) {
                        int actorToBackdropDistance = Math.abs(backdrop - actor);

                        // Ensure the backdrop is within the valid distance
                        if (actorToBackdropDistance >= X && actorToBackdropDistance <= Y) {
                            // Ensure the photographer and backdrop are on opposite sides of the actor
                            if ((photographer < actor && backdrop > actor) || (photographer > actor && backdrop < actor)) {
                                result++;  // Count this as a valid photo
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
