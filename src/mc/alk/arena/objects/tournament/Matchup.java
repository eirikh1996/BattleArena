package mc.alk.arena.objects.tournament;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mc.alk.arena.competition.match.Match;
import mc.alk.arena.listeners.TransitionListener;
import mc.alk.arena.objects.MatchParams;
import mc.alk.arena.objects.MatchResult;
import mc.alk.arena.objects.arenas.Arena;
import mc.alk.arena.objects.teams.Team;


public class Matchup {
	static int count = 0;
	final int id = count++; /// id

	public MatchResult result = new MatchResult();
	public List<Team> teams = new ArrayList<Team>();
	Arena arena = null;

	public Arena getArena() {return arena;}
	public void setArena(Arena arena) {this.arena = arena;}
	List<TransitionListener> listeners = new ArrayList<TransitionListener>();

	MatchParams q = null;
	Match match = null;

	public Matchup(MatchParams q, Team team, Team team2) {
		this.q = q;
		teams.add(team);
		teams.add(team2);
	}

	public Matchup(MatchParams sq, Collection<Team> teams) {
		this.teams = new ArrayList<Team>(teams);
		this.q = new MatchParams(sq);
	}

	public MatchParams getSpecificQ() {
		return q;
	}

	public void setResult(MatchResult result) {
		this.result = result;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (Team t: teams){
			sb.append("t=" + t +",");
		}
		return sb.toString() + " result=" + result;
	}
	public List<Team> getTeams() {return teams;}
	public Team getTeam(int i) {
		return teams.get(i);
	}
	public MatchResult getResult() {
		return result;
	}

	public boolean equals(Object other) {
		if (this == other) return true;
		if (!(other instanceof Team)) return false;
		return this.hashCode() == ((Team) other).hashCode();
	}

	public int hashCode() { return id;}

	public void addTransitionListener(TransitionListener transitionListener) {
		listeners.add(transitionListener);
	}

	public List<TransitionListener> getTransitionListeners() {
		return listeners;
	}

	public void addMatch(Match match) {
		this.match = match;
	}

	public Match getMatch(){
		return match;
	}
}