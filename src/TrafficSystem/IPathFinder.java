package TrafficSystem;

public interface IPathFinder {
	Route getPath(TrafficMap map, MPoint from, MPoint to);
}
