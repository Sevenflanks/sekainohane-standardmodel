package tw.org.sekainoane.standardmodel.grid;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import tw.org.sekainoane.standardmodel.grid.data.entity.OperationLogEntity;

/**
 * Gird Builder, 規劃可以自訂縱橫座標的group方式以及內容值的顯示方式
 * 目前還沒有能力實作出此功能, 暫時定義為無效
 * @author RHYS
 */
@Deprecated
public class GridFormatBuilder {
	
	private List<OperationLogEntity> entities;
	
	private Function<OperationLogEntity, Object> horizonGrouping;
	
	private Function<OperationLogEntity, Object> verticalGrouping;
	
	private Collector<Object, Object, Object> collecter;
	
	public GridFormatBuilder(List<OperationLogEntity> entities) {
		super();
		this.entities = entities;
	}
	
	public GridFormatBuilder horizonGroupBy(Function<OperationLogEntity, Object> groupingFunction) {
		this.horizonGrouping = groupingFunction;
		return this;
	}
	
	public GridFormatBuilder verticalGroupBy(Function<OperationLogEntity, Object> groupingFunction) {
		this.verticalGrouping = groupingFunction;
		return this;
	}
	
	public GridFormatBuilder collectBy(Collector<Object, Object, Object> collecter) {
		this.collecter = collecter;
		return this;
	}
	
	public List<Map<Integer, String>> build() {
		
		if (horizonGrouping != null) {
			Map<Object, List<OperationLogEntity>> result = entities.stream().collect(Collectors.groupingBy(horizonGrouping));
		}
		
		return null;
	}
	
}
