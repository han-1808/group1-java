import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
public class FinanceWindow {
    static private VBox centerVBox;
    static private VBox centerVBoxMember;
    static private TableView<EmployeeFinanceTable> table;
    static private TableView<MemberFinanceTable> tableMember;
    static private ConnectionClass conn;
    static private TableColumn<EmployeeFinanceTable, String> transactionType;
    static private TableColumn<EmployeeFinanceTable, String> occasion;
    static private TableColumn<EmployeeFinanceTable, Integer> id;
    static private TableColumn<EmployeeFinanceTable, String> name;
    static private TableColumn<EmployeeFinanceTable, String> time;
    static private TableColumn<EmployeeFinanceTable, Date> date;
    static private TableColumn<EmployeeFinanceTable, Integer> amount;
    static private TableColumn<EmployeeFinanceTable, Integer> enteredBy;
    static private TextField searchBox;
    static private Button searchBtn;
    static private Button refreshBtn;
    static private HBox search;
    static private ComboBox<String> searchOption;
    static private HBox centerTop;
    static private HBox dateBox;
    static private HBox lowestCenter;
    static private TextField total;
    static private Label totalLabel;
    static private Label rowSum;
    static private TableColumn<MemberFinanceTable, String> transactionTypeMember;
    static private TableColumn<MemberFinanceTable, String> occasionMember;
    static private TableColumn<MemberFinanceTable, Integer> idMember;
    static private TableColumn<MemberFinanceTable, String> nameMember;
    static private TableColumn<MemberFinanceTable, String> timeMember;
    static private TableColumn<MemberFinanceTable, Date> dateMember;
    static private TableColumn<MemberFinanceTable, Integer> amountMember;
    static private TableColumn<MemberFinanceTable, Integer> enteredByMember;
    static private TextField searchBoxMember;
    static private Button searchBtnMember;
    static private Button refreshBtnMember;
    static private HBox searchMember;
    static private ComboBox<String> searchOptionMember;
    static private HBox centerTopMember;
    static private HBox dateBoxMember;
    static private HBox lowestCenterMember;
    static private TextField totalMember;
    static private Label totalLabelMember;
    static private Label rowSumMember;
}
