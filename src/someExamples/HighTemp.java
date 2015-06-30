package someExamples;

//Assign a high temperature and check if assigned temperature is same or less than second
public class HighTemp {
	int h1;

	public HighTemp(int h1) {
		this.h1 = h1;
	}

	public boolean sameTemp(HighTemp h2) {
		return h1 == h2.h1;
	}

	public boolean lessTemp(HighTemp h2) {
		return h1 < h2.h1;
	}

}
