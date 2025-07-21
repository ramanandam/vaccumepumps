
CREATE TABLE "SYSTEM"."MACHINE_TABLE" (
    "CURVE_ID"         VARCHAR2(50),
    "MATERIAL"         NUMBER(10, 3),
    "OPERATING_MODE"   NUMBER(10, 3),
    "MACHINE_TYPE"     NUMBER,
    "RADDU"            NUMBER(10, 3),
    "GEOM"             NUMBER(10, 3),
    "NN"               NUMBER(10, 3),
    "NMAX"             NUMBER(10, 3),
    "EZAHLA"           NUMBER(10, 3),
    "EZAHLB"           NUMBER(10, 3),
    "PROOF"            NUMBER(10, 3),
    "P2MAX"            NUMBER(10, 3),
    "DPMIN"            NUMBER(10, 3),
    "DPMAX"            NUMBER(10, 3),
    "T3MAX"            NUMBER(10, 3),
    "T3MIN"            NUMBER(10, 3),
    "T1MIN"            NUMBER(10, 3),
    "T1TMAX"           NUMBER(10, 3),
    "T1FMAX"           NUMBER(10, 3),
    "PERMISSION_GROUP" NUMBER
);


CREATE TABLE list_value_table (
    curve_id          VARCHAR2(50),
    comp_pump         INTEGER,
    material          NUMBER(10, 2),
    speed             INTEGER,
    point             INTEGER,
    vac_group_pump_id INTEGER,
    px                INTEGER,
    sl                NUMBER(10, 3),
    pl                NUMBER(10, 3),
    fb                NUMBER(10, 3),
    raddu             NUMBER(10, 3),
    geom              NUMBER(10, 3),
    nn                NUMBER(10, 3),
    nmax              NUMBER(10, 3),
    ezahla            NUMBER(10, 3),
    ezahlb            NUMBER(10, 3),
    proof             NUMBER(10, 3),
    p2max             NUMBER(10, 3),
    dpmin             NUMBER(10, 3),
    dpmax             NUMBER(10, 3),
    t3max             NUMBER(10, 3),
    t3min             NUMBER(10, 3),
    t1min             NUMBER(10, 3),
    t1tmax            NUMBER(10, 3),
    t1fmax            NUMBER(10, 3),
    permission_group  INTEGER
);

CREATE TABLE error_table (
    error_code                                  INTEGER,
    error_type                                  INTEGER,
    error_description_in_german                 VARCHAR2(500),
    error_description_in_english                VARCHAR2(500),
    additional_parameters_german                VARCHAR2(500),
    additional_parameters_in_english            VARCHAR2(500),
    explanations_and_possible_remedies__german  VARCHAR2(1000),
    explanations_and_possible_remedies__english VARCHAR2(1000)
);


CREATE TABLE "SYSTEM"."SUBSTANCE_DATA_TABLE" (
    medium_id     NUMBER,
    formula       VARCHAR2(50),
    mol           NUMBER(30, 15),
    tflus         NUMBER(30, 15),
    tsied         NUMBER(30, 15),
    tkrit         NUMBER(30, 15),
    pkrit         NUMBER(30, 15),
    vkrit         NUMBER(30, 15),
    omega         NUMBER(30, 15),
    tq            VARCHAR2(50),
    eq            VARCHAR2(50),
    tmax          NUMBER(30, 15),
    tmin          NUMBER(30, 15),
    pda           NUMBER(30, 15),
    pdb           NUMBER(30, 15),
    pdc           NUMBER(30, 15),
    pdd           NUMBER(30, 15),
    pdy           NUMBER,
    aq            VARCHAR2(50),
    roa           NUMBER(30, 15),
    rob           NUMBER(30, 15),
    roc           NUMBER(30, 15),
    rod           NUMBER(30, 15),
    roy           NUMBER,
    rq            VARCHAR2(50),
    vfa           NUMBER(30, 10),
    vfb           NUMBER(30, 15),
    vfc           NUMBER(30, 15),
    vfd           NUMBER(30, 15),
    vfy           NUMBER,
    vq            VARCHAR2(50),
    cpa           NUMBER(30, 15),
    cpb           NUMBER(30, 15),
    cpc           NUMBER(30, 15),
    cpd           NUMBER(30, 15),
    cpy           NUMBER,
    cq            VARCHAR2(50),
    permission_group    NUMBER,
    supply_liquid NUMBER
);



CREATE TABLE "SYSTEM"."SUBSTANCE_NAME_TABLE" (

    medium_name_id	number,
    medium_name	varchar2(50),
    language varchar2(10)	,
    medium_id number


);

CREATE TABLE "SYSTEM"."SOLUBILITY_TABLE" (

    GAS_STOFF_ID varchar2(50),
    LIQUID_SUBSTANCE_ID	varchar2(50),
    LOA	number(12,3),
    LOB	varchar2(50),
    LOC varchar2(50),
    LOD varchar2(50),
    LOY varchar2(50),
    LO  VARCHAR2(10),
    TLMIN varchar2(50),
    TLMAX varchar2(50)


);




 CREATE TABLE "SYSTEM"."GAS_RADIATOR_TABLE"
   (	"TYPE" VARCHAR2(50 BYTE),
	"Z" NUMBER,
	"PUMP" VARCHAR2(50 BYTE),
	"RPM" NUMBER,
	"PX0" NUMBER,
	"DRIVE" NUMBER(10,2),
	"PX1" NUMBER,
	"PX2" NUMBER,
	"PX3" NUMBER,
	"PX4" NUMBER,
	"PX5" NUMBER,
	"PX6" NUMBER,
	"VOL11" NUMBER,
	"VOL12" NUMBER,
	"VOL13" NUMBER,
	"VOL14" NUMBER,
	"VOL15" NUMBER,
	"VOL16" NUMBER,
	"PZWI1" NUMBER(10,2),
	"PZWI2" NUMBER(10,2),
	"PZWI3" NUMBER(10,2),
	"PZWI4" NUMBER(10,2),
	"PZWI5" NUMBER(10,2),
	"PZWI6" NUMBER(10,2)
   )



