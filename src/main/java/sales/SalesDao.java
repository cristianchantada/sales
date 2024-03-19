package sales;

import java.util.List;
import org.bson.codecs.configuration.CodecRegistry;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

import org.bson.conversions.Bson;
import org.bson.Document;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.*;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.model.Filters;


public class SalesDao implements DaoInterface {

	MongoClient conn;
	MongoDatabase database;
	MongoCollection<sales> collection;
	CodecRegistry pojoCodecRegistry;
	
	
	public SalesDao() {
		conn = this.getConnection();
		database = conn.getDatabase("sample_supplies").withCodecRegistry(pojoCodecRegistry);
		collection = database.getCollection("sales", sales.class);
	}
	
	private MongoClient getConnection() {
		String url = "mongodb+srv://cristianchantada:cristian@cristian-instance.rrvjjrp.mongodb.net/?retryWrites=true&w=majority";
		pojoCodecRegistry=fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		MongoClient mongoClntObj = MongoClients.create(url);
		return mongoClntObj;
	}
	
	
	public ArrayList<Store> searchStoresByLocation (String aStoreLocation){
		
		ArrayList<sales> salesList = collection.find(Filters.eq("storeLocation", aStoreLocation)).into(new ArrayList<sales>());
		ArrayList<Store> storesList = new ArrayList<>();
		
		for(sales sale: salesList) {
			Store store = new Store();
			store.setStoreLocation(sale.getStoreLocation());
			store.setPurchaseMethod(sale.getPurchaseMethod());
			storesList.add(store);
		}
		return storesList;
	}
	
	public ArrayList<Store> searchStoresByLocationAndPurchaseMethod(String aStoreLocation, String aPurchasedMethod){
		ArrayList<sales> salesList = collection.find(Filters.and(eq("storeLocation", aStoreLocation), eq("purchaseMethod",aPurchasedMethod))).into(new ArrayList<sales>());
		ArrayList<Store> storesList = new ArrayList<>();
		
		for(sales sale: salesList) {
			Store store = new Store();
			store.setStoreLocation(sale.getStoreLocation());
			store.setPurchaseMethod(sale.getPurchaseMethod());
			storesList.add(store);
		}
		
		return storesList;
	}
	
	@Override
	public void save(Object s) {
		collection.insertOne((sales) s);
	}
	
	@Override
	public Object get(Object t) {
;
		return null;
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Object t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
