package com.UtilClass.Connection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class QueryBuilder {
	
	private StringJoiner query = new StringJoiner(" ");
	
	private String table;
	
	private String[] logicOperators = {"=", "<>", ">", ">=", "<", "<="};
	
	private Map<String, Object> whereParams = new HashMap<String, Object>();
	
	private Map<String, Object> updateParams = new HashMap<String, Object>();
	
	private Map<String, Object> insertParams = new HashMap<String, Object>();

	public StringJoiner getQuery() {
		return query;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	private String[] getLogicOperators() {
		return logicOperators;
	}

	private Map<String, Object> getWhereParams() {
		return whereParams;
	}

	private void setWhereParams(Map<String, Object> whereParams) {
		this.whereParams = whereParams;
	}

	private Map<String, Object> getUpdateParams() {
		return updateParams;
	}

	private void setUpdateParams(Map<String, Object> updateParams) {
		this.updateParams = updateParams;
	}

	private Map<String, Object> getInsertParams() {
		return insertParams;
	}

	private void setInsertParams(Map<String, Object> insertParams) {
		this.insertParams = insertParams;
	}
	
	public void reset() {
		query = new StringJoiner(" ");
	}
	
	QueryBuilder() {
		
	}
	
	QueryBuilder(String table) {
		setTable(table);
		setWhereParams(new HashMap<String, Object>());
		setInsertParams(new HashMap<String, Object>());
		setUpdateParams(new HashMap<String, Object>());
	}
	
	public void select(String[]... columns) {
		query.add("SELECT");
		if (columns.length == 0) {
			query.add("*");
		} else {
			query.add(Arrays.toString(columns).replace("[", "").replace("]", ""));
		}
		
		query.add("FROM").add(getTable());
	}
	
	public void insert(HashMap<String, Object> fields) {
		query.add("INSERT INTO").add(getTable()).add("(");
		Set<String> keys = fields.keySet();
		query.add(fields.keySet().toArray().toString().replace("[", "").replace("]", "")).add(") VALUES (");
		for (int i = 0; i < keys.size(); i++) {
			int keySize = keys.size();
			if (i < keySize) {
				query.add("?");
				if (i + 1 < keySize) {
					query.add(",");
				}
			}
		}
		query.add(")");
	}
//
//    /**
//     * Executive Methods
//     */
//    public function select(array $columns)
//    {
//        $columns = implode(",", $columns);
//
//        $this->prependQuery("SELECT $columns FROM {$this->getTable()}");
//    }
//
//    public function insert(array $fields)
//    {
//        $this->addInsertParams($fields);
//
//        $fieldsToBind = array_keys($fields);
//
//        $columns = implode(",", $fieldsToBind);
//
//        $values = ":" . implode(",:", $fieldsToBind);
//
//        $this->prependQuery("INSERT INTO $this->table($columns) VALUES ($values)");
//    }
//
//    public function update(array $fields)
//    {
//        $this->addUpdateParams($fields);
//
//        $fieldsToBind = array_map(function ($key) {
//            return "$key = :$key";
//        }, array_keys($fields));
//
//        $fieldsToBind = implode(",", $fieldsToBind);
//
//        $this->prependQuery("UPDATE $this->table SET $fieldsToBind");
//    }
//
//    public function delete()
//    {
//        $this->prependQuery("DELETE FROM $this->table");
//    }
//
//    public function where($column, $operator, $value)
//    {
//        if (!in_array($operator, $this->logicOperators)) {
//            throw new InvalidArgumentException("Invalid operator in QueryBuilder->where()");
//        }
//
//        $this->appendQuery((count($this->getWhereParams()) ? "AND" : "WHERE") . " " . $column . " " . $operator . " :" . $column);
//
//        $this->addWhereParams($column, $value);
//    }
//
//    public function join($table, $firstColumn, $secondColumn) {
//        $this->appendQuery("JOIN $table ON $firstColumn = $secondColumn");
//    }

}
