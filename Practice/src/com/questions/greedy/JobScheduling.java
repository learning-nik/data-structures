package com.questions.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*https://www.geeksforgeeks.org/job-sequencing-problem/?ref=lbp
*/
public class JobScheduling {

	public static void main(String[] args) {

		List<Job> list = new ArrayList<>();
		list.add(new Job(1, 2, 100));
		list.add(new Job(2, 1, 19));
		list.add(new Job(3, 2, 27));
		list.add(new Job(4, 1, 25));
		list.add(new Job(4, 3, 15));
		
		System.out.println(findMaxProfit(list));
	}

	private static int findMaxProfit(List<Job> list) {

		Collections.sort(list);

		System.out.println(list);

		int maxProfit = 0;
		int timeTaken = 0;

		for (Job job : list) {
			if (job.getDeadline() > timeTaken) {
				maxProfit = maxProfit + job.getProfit();
				timeTaken++;
			}
		}

		return maxProfit;
	}

}

class Job implements Comparable<Job> {

	private Integer id;
	private Integer deadline;
	private Integer profit;

	Job(Integer id, Integer deadline, Integer profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	public Integer getId() {
		return id;
	}

	public Integer getDeadline() {
		return deadline;
	}

	public Integer getProfit() {
		return profit;
	}

	@Override
	public int compareTo(Job o) {
		return -(this.profit.compareTo(o.profit));
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", deadline=" + deadline + ", profit=" + profit + "]";
	}

}
