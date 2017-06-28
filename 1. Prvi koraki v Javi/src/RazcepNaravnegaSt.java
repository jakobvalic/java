
public class RazcepNaravnegaSt {
	
	public static void main(String[] args) {
		razcep(5761665);
		razcep(1888888);
		razcep(100);
		razcep(1000);
	}
		
	/** Izpi�e razcep naravnega �tevila na prafaktorje.
	 * @param n - Dano naravno �tevilo
	 */
	public static void razcep(int n) {
		System.out.print(n);
		String operator = " = ";
		int delitelj = 2;
		while (delitelj*delitelj <= n) {
			int eksponent = 0;
			while (n % delitelj == 0) {
				n /= delitelj;
				eksponent ++;
			}
			if (eksponent > 0) {
				System.out.print(operator + delitelj);
				operator = " * ";
				if (eksponent > 1) {
					System.out.print("^" + eksponent);
				}
			}
			delitelj++;
		}
		if (n > 1) {
			System.out.print(operator + n);
		}
		System.out.println();
	}
		

		

	

}
