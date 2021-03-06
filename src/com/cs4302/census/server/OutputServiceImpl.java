package com.cs4302.census.server;

import java.util.List;

import com.cs4302.census.client.OutputService;
import com.cs4302.census.server.provider.OutputProvider;
import com.cs4302.census.shared.Tuple;
import com.cs4302.census.shared.profiles.CountyProfile;
import com.cs4302.census.shared.profiles.PlaceProfile;
import com.cs4302.census.shared.profiles.StateProfile;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class OutputServiceImpl extends RemoteServiceServlet implements OutputService {

  private static final long serialVersionUID = 1L;
  private final OutputProvider outputProvider;
  
  public OutputServiceImpl() {
    this.outputProvider = new OutputProvider();
  }
  @Override
  public CountyProfile getCountyProfile(Long stateFP, Long countyFP) {
    return outputProvider.getCountyProfile(stateFP, countyFP);
  }

  @Override
  public StateProfile getStateProfile(Long stateFP) {
	return outputProvider.getStateProfile(stateFP);
  }

  @Override
  public PlaceProfile getPlaceProfile(Long stateFP, Long placeFP) {
    return outputProvider.getPlaceProfile(stateFP, placeFP);
  }
  
  @Override
  public List<Tuple> getCountyList(Long stateFP){
	  return outputProvider.getCountyList(stateFP);
  }
  
  @Override
  public List<Tuple> getPlaceList(Long stateFP, Long countyFP){
	  return outputProvider.getPlaceList(stateFP, countyFP);
  }

}


//public void addGoal(int userId, String title, String description) {
//  
//  Goal goal = new Goal(userId, title, description);
//  ofy.put(goal);
//  assert goal.getId() != null;
//}
//
//public void removeGoal(Long goalId) {
//  Key<Goal> goal = new Key<Goal>(Goal.class, goalId);
//  ofy.delete(goal);
//}
//
//public Goal getGoal(Long goalId) {
//  Key<Goal> goal = new Key<Goal>(Goal.class, goalId);
//  return ofy.get(goal);
//}
//
//public Goal[] getUserGoals(Long[] userIds) {
//  List<Goal> goals = new ArrayList<Goal>();
//  for (Long userId : userIds) {
//    Query<Goal> q = ofy.query(Goal.class).filter("userId =", userId);
//    for (Goal goal: q) {
//      goals.add(goal);
//      System.out.println(goal.getTitle());
//    }
//  }
//  return goals.toArray(new Goal[goals.size()]);
//}
